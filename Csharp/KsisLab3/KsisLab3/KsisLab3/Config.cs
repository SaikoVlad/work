using System;
using System.Net;
using System.Net.NetworkInformation;
using System.Net.Sockets;
using System.Text;

namespace KsisLab3
{
    public class Config
    {
        private StringBuilder stringBuilder = new StringBuilder();
        public string IpConfig()
        {
            try
            {
                IPGlobalProperties ipGlobalProperties = IPGlobalProperties.GetIPGlobalProperties();
                //StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.Append("--------------------------------------------------");
                stringBuilder.Append("\nHostname: " + ipGlobalProperties.HostName);
                stringBuilder.Append("\nDomain name: " + ipGlobalProperties.DomainName);
                NetworkInterface[] adapters = NetworkInterface.GetAllNetworkInterfaces();
                stringBuilder.Append("\nNetwork interfaces: " + adapters.Length);
                foreach (var adapter in adapters)
                {
                    AdaptersInfo(adapter);
                }
                stringBuilder.Append("\n\t\t\tDNS");
                stringBuilder.Append("\n--------------------------------------------------");
                stringBuilder.Append("\nDNS name:\t\t" + Dns.GetHostName());
                try
                {
                    IPAddress[] dnsAddresses = Dns.GetHostAddresses(Dns.GetHostName());
                    foreach (var ipAddress in dnsAddresses)
                    {
                        if (ipAddress.AddressFamily == AddressFamily.InterNetwork)
                        {
                            stringBuilder.Append("\nIPv4:\t\t\t" + ipAddress);
                        }
                        else if (ipAddress.AddressFamily == AddressFamily.InterNetworkV6)
                        {
                            stringBuilder.Append("\nIPv6:\t\t\t" + ipAddress);
                        }
                    }
                }
                catch (Exception exception)
                {
                    stringBuilder.Append("Can't find DNS!");
                }
                finally
                {
                    stringBuilder.Append("\n--------------------------------------------------");
                    stringBuilder.Append("\n\t\t\tIP");
                    stringBuilder.Append("\n--------------------------------------------------");
                    IPAddress loop = IPAddress.Loopback;
                    stringBuilder.Append("\nLoopback:\t\t\t" + loop);
                    loop = IPAddress.Broadcast;
                    stringBuilder.Append("\nBroadcast:\t\t\t" + loop);
                    loop = IPAddress.Any;
                    stringBuilder.Append("\nAny:\t\t\t\t" + loop);
                    stringBuilder.Append("\n--------------------------------------------------");
                }
                
            }
            
            
            catch (Exception exception)
            {
                Console.WriteLine(exception.ToString());
            }
            return stringBuilder.ToString();
        }
        private void AdaptersInfo(NetworkInterface adapter)
        {
            stringBuilder.Append("\n--------------------------------------------------");
            stringBuilder.Append("\nName:\t\t\t" + adapter.Name);
            stringBuilder.Append("\nType:\t\t\t" + adapter.NetworkInterfaceType);
            stringBuilder.Append("\nDescription:\t\t" + adapter.Description);
            stringBuilder.Append("\nStatus:\t\t\t" + adapter.OperationalStatus);
            GetNetworkInfo(adapter);
            IPAddress ipAddress = IPAddress.Broadcast;
            IPInterfaceProperties adapterIp = adapter.GetIPProperties();
            UnicastIPAddressInformationCollection
                unicastIpAddressInformationCollection = adapterIp.UnicastAddresses;
            if (unicastIpAddressInformationCollection.Count > 0)
            {
                GetUnicastIpAddressInformationFromCollection(unicastIpAddressInformationCollection);
            }
            stringBuilder.Append("\n--------------------------------------------------");
        }
        private void GetUnicastIpAddressInformationFromCollection(UnicastIPAddressInformationCollection unicastIpAddressInformationCollection)
        {   
            foreach (var ip in unicastIpAddressInformationCollection)
            {
                if (ip.Address.AddressFamily == AddressFamily.InterNetwork)
                {
                    stringBuilder.Append("\nIPv4:\t\t\t" + ip.Address);
                    stringBuilder.Append("\nMask:\t\t\t" + ip.IPv4Mask);
                    stringBuilder.Append("\nBytes:\t\t\t" + ip.Address.GetAddressBytes().Length);
                }

                if (ip.Address.AddressFamily == AddressFamily.InterNetworkV6)
                {
                    stringBuilder.Append("\nIPv6:\t\t\t" + ip.Address);
                    stringBuilder.Append("\nBytes:\t\t\t" + ip.Address.GetAddressBytes().Length);
                }
            }
        }
        private void GetNetworkInfo(NetworkInterface adapter)
        {
            PhysicalAddress address = adapter.GetPhysicalAddress();
            byte[] bytes = address.GetAddressBytes();
            if (bytes.Length > 0)
            {
                stringBuilder.Append("\nPhysical Address:\t");
                for (int i = 0; i < bytes.Length; i++)
                {
                    stringBuilder.Append(bytes[i].ToString("x2"));
                    if (i + 1 < bytes.Length)
                    {
                        stringBuilder.Append("-");
                    }
                }
                stringBuilder.Append("\nBytes:\t\t\t" + bytes.Length);
            }
        }
    }    
}